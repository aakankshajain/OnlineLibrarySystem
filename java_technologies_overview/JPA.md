#JPA (Java Persistance API)

JPA is a collection of classes nd methods which stores data into database persistantly. JPA is basically used to perform database operations efficienty and provides a connecting chain between java program and database. It is provided by Oracle.<br>

To use JPA we need to use JPA Provider framework. It makes easier to interact with database.<br>
JPA is open source API which is included in many tools like eclipse,redHat etc.<br>

JPA consider POJO as a record of database.<br>

###Classes and interfaces used :

Persistance : It is a class which has a static method to create instance of EntityManagerFactoty.<br>
EntityManagerFactory : It is a factory class for EntityManager interface. Also manages multiple objects of EntityManager.<br>
EntityManager :  It is a interface works like factory of Query instance. It is used to manage the persistance operation on objects.<br>
Query : It is a interface used to fetch data from database.<br>
Entity  : It is a record in form of object which store in database.<br>
EntityTransection : It has one to one relationship with EntityManager.<br> 

###ORM (Object Relational Mapping) : 

Previously what was the scenario we were needed to write code to store object into relational database everytime.We explicitly needed to maintain those records.This was very tedious task.<br>
Now to reduce these overheads we are moving to object relation mappings.in which we only need to provide a .xml file containing all mappings between POJOs and relational database and data insertion maintenance etc operations are automatically handled.<br>
ORM is a technology that converts object type data to relation database records and vice versa.<br>

The benefit for .xml file is it does not require compilation so we can easily make changes anytime.<br>

###How it works :
There are three phases : <br>
1. In first phase there are POJOs. Classes whose object are being stored in database as records.<br>
2. Second phase is JPA provider (eg : Hibernate), A framework or platform which will persist data to store in database and a xml mapping file.<br>
Third phase is a relational database which will store data.<br>

In first phase data is in transient state what it means is object of classes which we want to store is initially in transient state.<br>
In second phase when data binded with JPA provider comes in peersistant state.<br>
In last phase persistent data stored in database as  record.<br>

#Mapping file

Mapping file is a .xml file. It contains mapping between a java class and its corresponding table in database.<br>
Java class contain variables (a variable corresponding to a column in table to which class pointing to) and getters and setters for that variable.<br>

Eg : Student.java class mapped to StudentInfo table in database. Then mapping file would be : <br>

DTD
entity-mapping ...
entity class="Student"
	table name="StudentInfo"/
	
	attributes
		
		id name="studentId"
		column name="student_id"
		generated-value=".."
		/id
		
		basic name="name"
		column name="studentName"
		/basic
		
/attributes

/entity
/entity-mapping


As Student.java is like this<br>

class Student {
	String id;
	String name;
	
	public void setId(String id){
		this.id=id;
	}
	public void setName(String Name){
		this.name=name;
	}
	public String getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
}


In xml file : <br>
1. write DTD<br>
2. entity-mapping : allows entity tag in xml file<br>
3. entity : for mapping between java class and database table<br>
4. id : for defining primary key<br>
5. generated-value : for specifying hoe primary key would be generated.<br>
6. basic : for mapping rest variables of class with column of tables.<br>


Here we need to explicitly maintain a mapping file in which we always need to check variables name column names of table for mapping.
To overcome this issue we can use annotations.

###Annotation

Using annotations we provide the mapping from to database table from class itself.
annotaions always starts with "@".Annotations are used for class,variables and methodS And used above declaration.
These annotation are defined in javax.persistance package.

@Entity : To declare the class as a table
@Table : to define name of the table on which class is pointing.
@Column : To specify to which column class's variable is pointing.
@Id : To define a class's variable as primary key of corresponding table.
@Basic : For those class's variables having no constraint in table.


#### How to insert a record in database using JPA:
As we have created a POJO class Employee.java

For inserting one record in database one class need to be written :

InsertData.java

	EntityManagerFactory emf=Persistance.createEntityManagerFactory("Eclipselink_JPA");
	EntityManager em=emf.creteEntityManager();
	em.getTransection().begin();
	Employee e =new Employee();
	e.setId("1");
	e.setName("abc");
	em.persist(e);
	em.getTransection().commit();
	em.close();
	emf.close();

This block of code need to be written for inserting a record.

Like this we can also update data.

