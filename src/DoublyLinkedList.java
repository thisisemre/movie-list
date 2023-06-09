public class DoublyLinkedList {
    private Node head;/* son eklenen */

    private Node tail;


    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }


    public void insertData(Movie movie){
        Node new_node = new Node(movie);
        if(isEmpty()){
            this.tail = new_node;
            new_node.next = this.head;
            this.head = new_node;
        }

        else{
            if(new_node.data.getYear()>this.head.data.getYear()){
                this.head.prev = new_node;
                new_node.next = this.head;
                this.head = new_node;
            } else if (new_node.data.getYear()<this.head.data.getYear()) {
                Node current = this.head;
                while (current.next != null && new_node.data.getYear() < current.next.data.getYear()) {
                    current = current.next;
                }
                new_node.next = current.next;
                if (current.next != null) {
                    current.next.prev = new_node;
                } else {
                    this.tail = new_node;
                }
                current.next = new_node;
                new_node.prev = current;

            }else{
                int compare=new_node.data.getName().compareTo(this.head.data.getName());
                if(compare<0){
                    this.head.prev = new_node;
                    new_node.next = this.head;
                    this.head = new_node;
                } else if (compare>0) {
                    Node current = this.head; /* optimali this.head.next olur tekrar dön */
                    while (current.next != null && new_node.data.getName().compareTo(current.next.data.getName())>0) {
                        current = current.next;
                    }
                    new_node.next = current.next;
                    if (current.next != null) {
                        current.next.prev = new_node;
                    } else {
                        this.tail = new_node;
                    }
                    current.next = new_node;
                    new_node.prev = current;

                }

            }
        }

    }
    public void display_before_2000s(){
        Node current = head;

        while (current != null ) {
            if(current.data.getYear()<2000){
                System.out.print(current.data + "\n");
            }
            current = current.next;
        }
    }
    public void display_from_head() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + "\n");
            current = current.next;
        }
    }
    public void display_from_tail(){

        Node current = tail;

        while (current != null) {
            System.out.print(current.data + "\n");
            current = current.prev;
        }
    }

    public void display_movie(String name){
        Node current = head;

        while (current != null ) {
            if(current.data.getName().equals(name)){
                System.out.print(current.data + "\n");
                return;
            }
            current = current.next;
        }
        System.out.println("İlgili film listede yok.Menüye geri döndürülüyor...");

    }
    public void delete_movie(String name){
        Node current = head;
        while (current!=null){
            if (current.data.getName().equals(name)) {
                if(current==head){
                    if(head==tail){
                        tail =null;
                    }else{
                        current.next.prev=null;
                    }
                    head=current.next;
                    current.next=null;


                } else if (current==tail) {
                    current.prev.next=null;
                    tail = current.prev;
                    current.prev=null;
                }else{
                    current.prev.next=current.next;
                    current.next.prev=current.prev;
                }
                System.out.println("İlgili film listeden silindi");
                return;
            }
            current=current.next;
        }
        System.out.println("İlgili film listede yok.Menüye geri döndürülüyor...");

    }
    public boolean emptyWarning(){
        if(isEmpty()){
            System.out.println("Liste boş!");
            return true;
        }
        return false;
    }
    public String get_all_data(){
        String data = "";
        Node current = head;
        while (current != null) {
            String actors = current.data.getActors().toString().replace("[","{").replace("]","}");
            actors = actors.replace("), (",")(");
            data += current.data.getYear()+","+current.data.getName()+","
                    +current.data.getGenre()+","+current.data.getDirector()+","+actors+"\n";
            current = current.next;
        }
        return data;
    }

}
