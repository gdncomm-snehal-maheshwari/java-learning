import java.util.Date;

public class MyListEmployee<E> {
    private ArrayList<Employee> head;
    private int size;

    static class Employee {
        public int id;
        public String name;
        public int age;
        public Date dateOfJoining;



        public Employee (int id, String name, int age, Date doj) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.dateOfJoining = doj;
        }
    }

    static class ArrayList<E> {
        Employee data;
        ArrayList<Employee> next;

        ArrayList(Employee d) {
            data = d;
            next = null;
        }
    }

    public MyListEmployee (int size) {
        this.size = size;
    }

    public void addItem (Employee val) throws Exception {
        if (this.size == 0) {
            throw new Exception("Size Limit Reached");
        }
        if (head == null) {
            head = new ArrayList<Employee>(val);
        } else {
            ArrayList<Employee> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ArrayList<Employee>(val);
        }
        this.size--;
    }

    public boolean deleteAtIndex (int index) {
        ArrayList<Employee> next = head;
        ArrayList<Employee> prev = head;
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

    public Object getValue(Employee emp, String type) {
        return switch (type) {
            case "id" -> emp.id;
            case "name" -> emp.name;
            case "age" -> emp.age;
            case "dateOfJoining" -> emp.dateOfJoining;
            default -> throw new IllegalArgumentException("Unknown field: " + type);
        };
    }

    public boolean deleteByValue (Employee val, String type) {
        if (!(type.equals("id") || type.equals("name") || type.equals("age") || type.equals("date"))) {
            return false;
        }
        ArrayList<Employee> next = head;
        ArrayList<Employee> prev = head;
        Object cmp = getValue(val, type);
        l1:while (next != null) {
            Object data = getValue(next.data, type);
            if (data == cmp) {
                prev.next = next.next;
                next.next = null;
                --this.size;
                return true;
            }
            prev = next;
            next = next.next;
        }

        return false;
    }

    public Employee getItemByIndex (int index) throws Exception {
        ArrayList<Employee> temp = head;
        int count = 0;
        while (temp.next != null && count < index) {
            temp = temp.next;
            count++;
        }

        if (count == index) {
            return temp.data;
        }

        throw new Exception("Item not found");
    }

    public void seeItemList () {
        ArrayList<Employee> temp = head;
        String data = "";
        while (temp.next != null) {
            String val = temp.data.id + " -> ";
            data = data.concat("{ id: " + temp.data.id + ", name: " + temp.data.name + ", age: " + temp.data.age + ", date: " + temp.data.dateOfJoining + " } \n");
            temp = temp.next;
        }
        data = data.concat("{ id: " + temp.data.id + ", name: " + temp.data.name + ", age: " + temp.data.age + ", date: " + temp.data.dateOfJoining + " }");
        System.out.println(data);
    }

    public static void main (String[] args) throws Exception {

        MyListEmployee<Employee> mylist = new MyListEmployee<Employee>(100);

        for(int i=1;i<=5;i++) {
            Employee employee = new Employee(i, "SM-"+i, 20+i, new Date());
            mylist.addItem(employee);
        }
        mylist.seeItemList();
        System.out.println();
        mylist.deleteAtIndex(3);
        mylist.seeItemList();
        System.out.println();
        Employee item = mylist.getItemByIndex(2);
        System.out.print("item -> ");
        System.out.println("{ id: " + item.id + ", name: " + item.name + ", age: " + item.age + ", date: " + item.dateOfJoining + " }");
        System.out.println();
        Employee employee = new Employee(1, "SM", 21, new Date());
        mylist.deleteByValue(employee, "id");
        mylist.seeItemList();
    }
}
