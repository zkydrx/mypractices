#Explain
1. This subject was solved with the internet's answer.
2. Think a lot with the method:
    
        public int swapBits(int n, int i, int j)
        {
            int a = (n >> i) & 1;
            int b = (n >> j) & 1;
            if ((a ^ b) != 0)
            {
                return n ^= (1 << i) | (1 << j);
            }
            return n;
        }
