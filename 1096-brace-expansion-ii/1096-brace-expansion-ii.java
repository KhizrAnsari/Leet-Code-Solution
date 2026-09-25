class Solution {
    private Set<String> build(String s){
        Set<String> parts = new HashSet<>();
        Set<String> curr = new HashSet<>();

        curr.add("");

        int i = 0;
        while (i<s.length()){
            if(s.charAt(i)=='{'){
                int j = i;
                int depth = 0;

                 while (true){
                    if(s.charAt(j) == '{'){
                        depth--;
                    }else if(s.charAt(j)=='}'){
                        depth++;
                    }
                    if(depth == 0){
                        break;
                    }
                    j++;
                 }
                 Set<String> options = build(
                    s.substring(i+1,j)
                 );
                 Set<String> next = new HashSet<>();
                 for(String a: curr){
                    for(String b: options){
                        next.add(a+b);
                    }
                 }
                 curr = next;
                 i=j+1;
            }
            else if(s.charAt(i) ==','){
                parts.addAll(curr);

                curr = new HashSet<>();
                curr.add("");
                i++;
            }else{
                Set<String> next = new HashSet<>();

                for(String x: curr){
                    next.add(x + s.charAt(i));
                }
                curr = next;
                i++;
            }
        }
        parts.addAll(curr);
        return parts;

    }
        public List<String> braceExpansionII(String expression) {
           List<String> result = new ArrayList<>(
            build(expression)
           );

           Collections.sort(result);
           return result;
}}