class Tweet{
    private int id;
    private int time;
    private Tweet next;
    public Tweet(int id,int time){
        this.id = id;
        this.time = time;
        this.next = null;
    }
}