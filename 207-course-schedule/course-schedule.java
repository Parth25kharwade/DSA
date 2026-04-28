class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int[] pre:prerequisites){
            if(map.containsKey(pre[1])){
                map.get(pre[1]).add(pre[0]);
            }else{
                List<Integer> nextCourse=new LinkedList<>();
                nextCourse.add(pre[0]);
                map.put(pre[1],nextCourse);
            }

        }
        HashSet<Integer> visited=new HashSet<>();

        for(int i=0;i<numCourses;i++){
            if(courseSchedual(i,visited,map)==false){
                return false;
            }
        }
        return true;
    }
    private static boolean courseSchedual(int course,HashSet<Integer> visited, HashMap<Integer,List<Integer>> graph){
        if(visited.contains(course)){
            return false;
        }
        if(graph.get(course)==null){
            return true;
        }
        visited.add(course);
        for(int pre:graph.get(course)){
            if(courseSchedual(pre,visited,graph)==false){
                return false;
            }
        }
        visited.remove(course);
        graph.put(course,null);
        return true;
    }
}