package assignment11;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file name:");
        String filename = sc.next();

        Map<Character,Integer> map = new HashMap<>();

        try
        {
            FileReader reader = new FileReader(filename);

            PrintWriter pw = new PrintWriter("output.txt");

            int ch=0;
            while((ch=reader.read())!=-1)
            {
                char temp = (char) ch;
                if (map.containsKey(temp))
                {
                    map.put(temp, map.get(temp) + 1);
                }
                else
                {
                    map.put(temp, 1);
                }
            }
            for(Map.Entry<Character,Integer> e:map.entrySet())
            {
                pw.println(e.getKey()+" "+e.getValue());
            }

            reader.close();
            pw.close();
        }
        catch (IOException e)
        {
            System.out.println("There is no such file");
        }
    }
}