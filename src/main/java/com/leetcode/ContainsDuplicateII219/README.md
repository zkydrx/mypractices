# Explain

1. It is amazing.
2. It use the HashMap's method and exchange the key and value.

   if (map.containsKey(nums[i]))
   {
   int pre = map.get(nums[i]);
   if (i - pre <= k)
   {
   return true;
   }
   }
