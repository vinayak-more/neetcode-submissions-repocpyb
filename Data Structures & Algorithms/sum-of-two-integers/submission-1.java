class Solution {
    public int getSum(int a, int b) {
        int sum = 0;
        int carry = 0;
        int x, y;
        int result = 0;
        int bit = 0;
        while( bit < 32){
            x = a & 1;
            y = b & 1;
            sum = x ^ y ^ carry;
            carry = (x & y) | (x & carry) | (y & carry);
            result |= (sum << bit);
            bit++;
            a = a >>> 1;
            b = b >>> 1;
        }
        return result;
    }
}
/*
s = sum
c = carry
sum is xor gate
carry is and gate
a   b   s   c
0   0   0   0
0   1   1   0
1   0   1   0
1   1   0   1
*/