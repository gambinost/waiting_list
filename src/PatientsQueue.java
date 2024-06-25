public class PatientsQueue {
    public class Node {
        Node next;
        Patient pat;

        public Node(Patient info) {
            this.pat = info;
        }

    }

    Node Head;
    Node Tail;

    public PatientsQueue() {
        Head = Tail = null;
    }


    public void Add(Patient info) {
        Node tail = new Node(info);

        if (Head == null) {
            Head = Tail = tail;
        } else {
            Tail.next = tail;
            Tail = tail;
        }
    }

    public void Calling() {
        if (Head != null) {
            System.out.println("Patient number '" + Head.pat.patientOrder + "': your turn.");
        } else {
            System.out.println("No patients in the queue.");
        }
    }


    public void Delete() {
        if (Head != null) {
            Head = Head.next;
            if (Head == null) {
                Tail = null;
            }
        }
    }

    public void Remove(String name) {
//        Node i = Head;
//        for (int count = 0; count < index - 1; count++) {
//            i = i.next;
//        }
//        i.next = i.next.next;
        Node i =Head;

    }

    public void PrintList() {
        Node i = Head;
        System.out.println("our order is : ");
        while (i != null) {
            System.out.println(i.pat.patientOrder + " - "+i.pat.name);
            i = i.next;
        }
        System.out.println();
    }

    public int number_of_patients() {
        int count = 0;
        Node i = Head;
        while (i != null) {
            count++;
            i = i.next;
        }
        return count;
    }
}


