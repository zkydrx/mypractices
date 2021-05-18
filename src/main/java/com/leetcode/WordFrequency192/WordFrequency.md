## 192. Word Frequency

Write a bash script to calculate the frequency of each word in a text file words.txt.

For simplicity sake, you may assume:

words.txt contains only lowercase characters and space ' ' characters. Each word must consist of lowercase characters
only. Words are separated by one or more whitespace characters. For example, assume that words.txt has the following
content:

the day is sunny the the the sunny is is Your script should output the following, sorted by descending frequency:
the 4 is 3 sunny 2 day 1 Note:
Don't worry about handling ties, it is guaranteed that each word's frequency count is unique.

### Read from the file words.txt and output the word frequency list to stdout.

    SOLUTION – CAT, TR, AWK, SORT
    1. cat words.txt | tr -s ' ' '\n' | awk '{nums[$1]++}END{for(word in nums) print word, nums[word]}' | sort -rn -k2
    
    SOLUTION – GREP, SORT, UNIQ, SORT, AWK
    2. grep -oE '[a-z]+' words.txt | sort | uniq -c | sort -r | awk '{print $2" "$1}'
    
    SOLUTION, SED, GREP, SORT, UNIQ, SORT, AWK
    3. sed -r 's/\s+/\n/g' words.txt | grep -v "^$" | sort | uniq -c | sort -r | awk '{print $2" "$1}'
    
    SOLUTION – AWK AND SORT
    4. awk '{words[$1]+=1} END{for(word in words){print word,words[word]}}' RS="[ \n]+" words.txt  | sort -nrk2
    
    SOLUTION CAT AND AWK
    5. cat words.txt | awk '{for(i=1;i<=NF;++i) { arr[$i]++; } } END { x=0; for(var in arr) {newarr[arr[var]]=var; if(arr[var]>x) x=arr[var];} for(i=x;i>0;--i) if (newarr[i] > 0) print newarr[i] " "i; }'
    
    SOLUTION – TR, SORT, UNIQ, SORT, AWK
    6. tr -s ' ' '\n' < words.txt|sort|uniq -c|sort -nr|awk '{print $2, $1}'
   
    SOLUTION - SED
    7. cat words.txt | tr -s '[[:space:]]' '\n'| sort | uniq -c | sort -r | sed -r -e 's/[[:space:]]*([[:digit:]]+)[[:space:]]*([[:alpha:]]+)/\2 \1/g'
    