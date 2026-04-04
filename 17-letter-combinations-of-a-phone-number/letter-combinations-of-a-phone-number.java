class Solution {
    public List<String> letterCombinations(String digits) {
         List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        String[] digitToLetters = {
            "",     
            "",     
            "abc",  
            "def",  
            "ghi",  
            "jkl",  
            "mno",  
            "pqrs", 
            "tuv",  
            "wxyz"  
        };
        
        backtrack(digits, digitToLetters, result, new StringBuilder(), 0);
        return result;
    }
    
    private void backtrack(String digits, String[] digitToLetters, List<String> result, StringBuilder current, int index) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        char digit = digits.charAt(index);
        String letters = digitToLetters[digit - '0'];
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(digits, digitToLetters, result, current, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}