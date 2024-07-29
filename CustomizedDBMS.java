// Customised Database Management System

class node
{
    private static int Counter = 1;
    public int Rno;
    public String Name;
    public String City;
    public int Marks;

    public node next;

    public node(String B, String C, int D)
    {
        Rno = Counter;
        Counter++;
        Name = B;
        City = C;
        Marks = D;
        next = null;
    }
}

class DBMS
{
    private node first;

    public DBMS()
    {
        first = null;
        System.out.println("DBMS initailised succesfully...");
        System.out.println("Student Table gets created succesfully...");
    }

    // InsertLast
    // insert into table student values(1,'Amit','Pune',89);
    public void InsertIntoTable(String Name, String City, int Marks)
    {
        node newn = new node(Name,City,Marks);

        if(first == null)
        {
            first = newn;
        }
        else
        {
            node temp = first;
            while(temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = newn;
        }
        System.out.println("One record gets inserted succesfully...");
    }

    // Display
    // select * from student
    public void SelectStarFrom()
    {
        System.out.println("Data from the student table is : ");

        node temp = first;

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
        while(temp != null)
        {
            System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            temp = temp.next;
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
    }

    //select * from student where city = '_____';
    public void SelectStarFromWhereCity(String str)
    {
        System.out.println("Data from the student table where city is : "+str);

        node temp = first;

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
        while(temp != null)
        {
            if(str.equals(temp.City))
            {
                System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            }
            temp = temp.next;
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
    }

    //4
    public void SelectCount()
    {
        node temp = first;
        int iCnt = 0;

        while(temp != null)
        {
            temp = temp.next;
            iCnt++;
        }

        System.out.println("Number of records in the table : "+iCnt);
    }

    //5
    public void SelectSum()
    {
        node temp = first;
        int iSum = 0;

        while(temp != null)
        {
            iSum = iSum + temp.Marks;
            temp = temp.next;
        }

        System.out.println("Summation of column Marks is : "+iSum);
    }

    //6
    public void SelectAvg()
    {
        node temp = first;
        int iSum = 0, iCnt = 0;

        while(temp != null)
        {
            iSum = iSum + temp.Marks;
            temp = temp.next;
            iCnt++;
        }

        System.out.println("Average of column Marks is : "+(float)((float)iSum/(float)iCnt));
    }

    //7
    public void SelectMax()
    {
        node temp = first;
        int iMax = 0, iCnt = 0;

        if(temp != null)
        {
            iMax = temp.Marks;
        }

        while(temp != null)
        {
            if(temp.Marks > iMax)
            {
                iMax = temp.Marks;
            }
            temp = temp.next;
        }

        System.out.println("Maximum of Marks is : "+iMax);
    }

    //8
    public void SelectMin()
    {
        node temp = first;
        int iMin = 0, iCnt = 0;

        if(temp != null)
        {
            iMin = temp.Marks;
        }

        while(temp != null)
        {
            if(temp.Marks < iMin)
            {
                iMin = temp.Marks;
            }
            temp = temp.next;
        }

        System.out.println("Minimum of Marks is : "+iMin);
    }

    //9
    public void SelectStarFromName(String str)
    {
        node temp = first;

        System.out.println("Information of students with name : "+str);
        while(temp != null)
        {
            if(str.equals(temp.Name))
            {
                System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            }
            temp = temp.next;
        }
    }

    //10
    public void UpdateCity(int no, String str)
    {
        node temp = first;

        while(temp != null)
        {
            if(temp.Rno == no)
            {
                temp.City = str;
                break;
            }
            temp = temp.next;
        }
        System.out.println("Record gets updated...");
    }

    //11
    public void DeleteFrom(int no)
    {
        node temp = first;

        //if LL is empty
        if(temp == null)
        {
            return;
        }

        //if first node is targated node
        if(temp.Rno == no)
        {
            first = first.next;
            return;
        }

        while(temp.next != null)
        {
            if(temp.next.Rno == no)
            {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }
}

class Program352JDBC
{
    public static void main(String Arg[])
    {
        DBMS obj = new DBMS();

        obj.InsertIntoTable("Amit","Pune",89);
        obj.InsertIntoTable("Pooja","Mumbai",95);
        obj.InsertIntoTable("Gauri","Pune",90);
        obj.InsertIntoTable("Amit","Nagar",81);
        obj.InsertIntoTable("Rahul","Satara",80);
        obj.InsertIntoTable("Neha","Pune",78);

        obj.SelectStarFrom();

        obj.SelectStarFromWhereCity("Pune");

        obj.SelectCount();

        obj.SelectSum();

        obj.SelectAvg();

        obj.SelectMax();

        obj.SelectMin();

        obj.SelectStarFromName("Amit");

        obj.UpdateCity(3,"Nashik");

        obj.SelectStarFrom();

        obj.DeleteFrom(5);

        obj.SelectStarFrom();

        obj.InsertIntoTable("Rukmini","Kolhapur",77);

        obj.SelectStarFrom();
    }
}

/*
Supported Queries

1 : insert into student values('Amit','Pune',78);
2 : select * from student;
3 : select * from student where City = '____';
4 : select Count(Marks) from students;
5 : select Sum(Marks) from students;
6 : select Avg(Marks) from students;
7 : select Max(Marks) from students;
8 : select Min(Marks) from students;
9 : select * star from where name = "____";
10 : update student set City = "____" where Rno = ___;
11 : delete from student where Rno = ___;


*/