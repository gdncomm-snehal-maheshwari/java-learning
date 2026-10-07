public class MyList {
    private ArrayList head;
    private int size;

    static class ArrayList {
        int data;
        ArrayList next;

        ArrayList(int d) {
            data = d;
            next = null;
        }
    }

    public MyList (int size) {
        this.size = size;
    }

    public void addItem (int val) throws Exception {
        if (this.size == 0) {
            throw new Exception("Size Limit Reached");
        }
        if (head == null) {
            head = new ArrayList(val);
        } else {
            ArrayList temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ArrayList(val);
        }
        this.size--;
    }

    public boolean deleteAtIndex (int index) {
        ArrayList next = head;
        ArrayList prev = head;
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

    public boolean deleteByValue (int val) {
        ArrayList next = head;
        ArrayList prev = head;

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

    public int getItemByIndex (int index) {
        ArrayList temp = head;
        int count = 0;
        while (temp.next != null && count < index) {
            temp = temp.next;
            count++;
        }

        if (count == index - 1) {
            return temp.data;
        }
        return -1;
    }

    public void seeItemList () {
        ArrayList temp = head;
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
        MyList mylist = new MyList(100);
        mylist.addItem(1);
        mylist.addItem(2);
        mylist.addItem(3);
        mylist.addItem(4);
        mylist.addItem(5);

        mylist.seeItemList();

        mylist.deleteAtIndex(2);
        mylist.seeItemList();

        mylist.deleteByValue(4);
        mylist.seeItemList();

        int val = mylist.getItemByIndex(3);
        System.out.println(val);
    }
}