# Explain

1. Very good. the highestOneBit() method's source code:

   public static int highestOneBit(int i) {
   // HD, Figure 3-1
   i |= (i >>  1);
   i |= (i >>  2);
   i |= (i >>  4);
   i |= (i >>  8);
   i |= (i >> 16);
   return i - (i >>> 1);
   }

2. Think the highestOneBit() it is that returns an int value with at most a single one-bit, in the position of the
   highest-order ("leftmost") one-bit in the specified int value