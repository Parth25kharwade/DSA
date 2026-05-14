class Solution {
    static int WHITE=1;
    static int GREY=2;
    static int BLACK=3;

    boolean isPossible;
    Map<Integer,Integer> color;
    Map<Integer,List<Integer>> adjList;
    List<Integer> ans;

    private void init(int course){
        this.isPossible=true;
        this.color=new HashMap<Integer,Integer>();
        this.adjList=new HashMap<Integer,List<Integer>>();
        this.ans=new ArrayList<Integer>();

        for(int i=0;i<course;i++){
           this.color.put(i,WHITE);
        }
    }

    private void dfs(int node){
        if(!this.isPossible){
            return;
        }
        this.color.put(node,GREY);

        for(Integer neighbour:this.adjList.getOrDefault(node,new ArrayList<Integer>())){
            if(this.color.get(neighbour)==WHITE){
                this.dfs(neighbour);
            }else if(this.color.get(neighbour)==GREY){
                this.isPossible=false;

            }
        }
        this.color.put(node,BLACK);
        this.ans.add(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.init(numCourses);
        for(int i=0;i<prerequisites.length;i++){
            int dest=prerequisites[i][0];
            int src=prerequisites[i][1];

            List<Integer> list=adjList.getOrDefault(src,new ArrayList<Integer>());
            list.add(dest);
            adjList.put(src,list);
        }
        for(int i=0;i<numCourses;i++){
           if(this.color.get(i)==WHITE){
            this.dfs(i);
           }
        }
        int[] order;
        if(this.isPossible){
            order=new int[numCourses];
            for(int i=0;i<numCourses;i++){
                order[i]=this.ans.get(numCourses-1-i);
            }
        }else{
            order=new int[0];
        }
        return order;
    }
}