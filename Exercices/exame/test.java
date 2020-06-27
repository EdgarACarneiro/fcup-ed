package exame;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

class Person {
    private String name;
    private int idade;

    public Person (String name, int idade) {
        this.idade = idade;
        this.name = name;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}


class Student extends Person {
    private int number;

    public Student (String name, int idade, int number) {
        super(name, idade);
        this.number = number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }
    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }
}

public class test {
    public static void bitRep(int n) {
        
        int one = 0;

        for (int i = 30; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                System.out.print("1");
                one++;
            } else {
                if (one > 0)
                    System.out.print("0");
            }
        }
    
        if (one == 0)   // All the bits are 0, the number is 0
            System.out.println("0");

        System.out.println();
    }

    public static int bitsOn (int k) {
        int number = 0;
        for (int i = 0; i <= 30; i++) {
            if ((k & (1 << i)) != 0)
               number++; 
        }
        return number;
    }

    public static void main (String[] args) {
        int i1 = 5;
        int i2 = 15;
        int i3 = 20;

        // Criar um Student usando o construtor Student
        Student person = new Student("Pedro", 19, 201905272);
        Student person1 = new Student("PedroV2", 19, 201905272);       

        // Criar um Person usando um construtor Student
        Person person2 = new Student("PedroV3", 19, 201905272);
        
        // ERRO: Usar o construtor de uma superclasse para criar uma subclasse
        // Student person3 = new Person("PedroV3", 19);

        //System.out.println(i1 + " " + i2 + " " + i3);
        
        //bitRep(i1); 
        //bitRep(i2); 
        //bitRep(i3);
        
        //System.out.println(bitsOn(i2) + " " + bitsOn(i2) + " " + bitsOn(i3));
       // System.out.println(i1 + " " + i2 + " " + i3);

/*        System.out.printf("|%+-10.3f|%n", Math.PI , Math.E );
       System.out.printf("|%010.3f|%n", Math.PI, Math.E ); */

        String s = "pedro";
        System.out.println(s.substring(1,3));

        int num = 16; 
        System.out.println((num & 1) == 0); // ver se num é par
        System.out.println((15 & 0b1011));
    }
}