class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();

        String[] phone={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result=new ArrayList<>();

        backtrack(0,digits,"",phone,result);

        return result;
    }

    void backtrack(int i,String digits,String path,
                   String[] phone,List<String> result) {

        if(i==digits.length()){
            result.add(path);
            return;
        }

        String letters=phone[digits.charAt(i)-'0'];

        for(char c:letters.toCharArray()){
            backtrack(i+1,digits,path+c,phone,result);
        }
    }
}