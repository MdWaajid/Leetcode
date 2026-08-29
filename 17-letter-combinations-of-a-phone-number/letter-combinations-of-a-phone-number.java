class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();

        String[] phone={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result=new ArrayList<>();
        StringBuilder path=new StringBuilder();

        backtrack(0,digits,phone,path,result);
        return result;
    }

    void backtrack(int i,String digits,String[] phone,
                   StringBuilder path,List<String> result) {
        if(i==digits.length()){
            result.add(path.toString());
            return;
        }

        String letters=phone[digits.charAt(i)-'0'];

        for(char c:letters.toCharArray()){
            path.append(c);
            backtrack(i+1,digits,phone,path,result);
            path.deleteCharAt(path.length()-1);
        }
    }
}