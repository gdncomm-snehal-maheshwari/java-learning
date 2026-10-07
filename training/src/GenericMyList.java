public class GenericMyList<E> {
    private ArrayList<E> head;
    private int size;

    static class ArrayList<E> {
        E data;
        ArrayList<E> next;

        ArrayList(E d) {
            data = d;
            next = null;
        }
    }

    public GenericMyList (int size) {
        this.size = size;
    }

    public void addItem (E val) throws Exception {
        if (this.size == 0) {
            throw new Exception("Size Limit Reached");
        }
        if (head == null) {
            head = new ArrayList<E>(val);
        } else {
            ArrayList<E> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ArrayList<E>(val);
        }
        this.size--;
    }

    public boolean deleteAtIndex (int index) {
        ArrayList<E> next = head;
        ArrayList<E> prev = head;
        int count = 0;
        while (next.next != null && count != index) {
            count++;
            prev = next;
            next = next.next;
        }

        if (count < index) {
            return false;
        } else {
            prev.next = next.next;
            next.next = null;
            this.size++;
            return true;
        }
    }

    public boolean deleteByValue (E val) {
        ArrayList<E> next = head;
        ArrayList<E> prev = head;

        while (next.next != null && next.data != val) {
            prev = next;
            next = next.next;
        }

        if (next.next == null) {
            if (next.data != val) {
                return false;
            } else {
                prev.next = null;
                this.size++;
                return true;
            }
        }

        prev.next = next.next;
        next.next = null;
        --this.size;
        return true;
    }

    public E getItemByIndex (int index) throws Exception {
        ArrayList<E> temp = head;
        int count = 0;
        while (temp.next != null && count < index) {
            temp = temp.next;
            count++;
        }

        if (count == index - 1) {
            return temp.data;
        }

        throw new Exception("Item not found");
    }

    public void seeItemList () {
        ArrayList<E> temp = head;
        String data = "";
        while (temp.next != null) {
            String val = temp.data + " -> ";
            data = data.concat(val);
            temp = temp.next;
        }
        data = data.concat(temp.data + "");
        System.out.println(data);
    }

    public static void main (String[] args) throws Exception {
        GenericMyList<String> mylist = new GenericMyList<String>(100);
        mylist.addItem("1");
        mylist.addItem("2");
        mylist.addItem("3");
        mylist.addItem("4");
        mylist.addItem("5");

        mylist.seeItemList();

        mylist.deleteAtIndex(2);
        mylist.seeItemList();

        mylist.deleteByValue("4");
        mylist.seeItemList();

        String val = mylist.getItemByIndex(3);
        System.out.println(val);
    }
}