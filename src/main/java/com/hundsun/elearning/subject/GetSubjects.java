package com.hundsun.elearning.subject;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class GetSubjects
{
    public static void main(String[] args) throws IOException
    {

        byte[] strByte = getContent("D:\\zky\\projects\\github\\mypractices\\src\\main\\java\\com\\hundsun\\elearning"
                                            + "\\subject\\b1.txt");
        String stringData = new String(strByte);
        JSONObject jsonObject = JSONUtil.parseObj(stringData, true, true);

        StringBuffer stringBuffer =new StringBuffer();
        JSONArray jsonArray = jsonObject.getJSONObject("Data").getJSONArray("userQues");
        for (int i = 0; i < jsonArray.size(); i++)
        {
            Object name = jsonArray.getJSONObject(i).get("name");
            JSONArray uqList = jsonArray.getJSONObject(i).getJSONArray("uqList");
            stringBuffer.append(name+"\n\n");
            for (int i1 = 0; i1 < uqList.size(); i1++)
            {
                String questionContent = uqList.getJSONObject(i1).get("questionContent").toString();
                String explainText = uqList.getJSONObject(i1).get("explainText").toString();
                JSONArray choiceItems = uqList.getJSONObject(i1).getJSONArray("choiceItems");
                StringBuffer itembuffer= new StringBuffer();
                for (int i2 = 0; i2 < choiceItems.size(); i2++)
                {
                    String a = choiceItems.getJSONObject(i2).get("itemCode").toString();
                    String  itemContent= choiceItems.getJSONObject(i2).get("itemContent").toString();
                    String  isAnswer= choiceItems.getJSONObject(i2).get("isAnswer").toString();
                    if(isAnswer.equals("1"))
                    {
                        itembuffer.append( a+"."+itemContent+"(√)\n");
                    }
                    else
                    {
                        itembuffer.append( a+"."+itemContent+"(×)\n");
                    }
                }
                int num = i*100+i1+1;
                if(!"null".equals(explainText))
                {
                    stringBuffer.append(num+"."+questionContent+"\n\n").append(itembuffer.append("\n")).append(explainText+
                                                                                                                       "\n" +
                                                                                                                       "\n");
                }
                else
                {
                    stringBuffer.append(num+"."+questionContent+"\n\n").append(itembuffer.append("\n\n"));
                }
            }

        }
        writeToText(stringBuffer.toString(),"证券从业法律法规模拟");
    }

    public static byte[] getContent(String filePath) throws IOException
    {
        File file = new File(filePath);
        long fileSize = file.length();
        if (fileSize > Integer.MAX_VALUE)
        {
            System.out.println("file too big...");
            return null;
        }
        FileInputStream fi = new FileInputStream(file);
        byte[] buffer = new byte[(int) fileSize];
        int offset = 0;
        int numRead = 0;
        while (offset < buffer.length && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0)
        {
            offset += numRead;
        }
        // 确保所有数据均被读取
        if (offset != buffer.length)
        {
            throw new IOException("Could not completely read file " + file.getName());
        }
        fi.close();
        return buffer;
    }


    /**
     * 生成文件
     * @param musicInfo
     * @param fileName
     * @throws IOException
     */
    public static void writeToText(String musicInfo, String fileName) throws IOException
    {
        // 生成的文件路径
        String path = "D:\\data\\" + fileName + ".txt";
        File file = new File(path);
        if (!file.exists())
        {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        // write 解决中文乱码问题
        // FileWriter fw = new FileWriter(file, true);
        OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(musicInfo);
        bw.flush();
        bw.close();
        fw.close();

    }


}
