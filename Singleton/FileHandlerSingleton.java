
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class FileHandlerSingleton
// import all the required header files

{
    private static volatile FileHandlerSingleton File_instance;

    // making  volatile so that change made by one thread will be reflected to
    // other threads as well

     private File myFile;

    // Making private Constructor to prevent the  instantiation from outside
    private FileHandlerSingleton()
    {

        String path = "./example.txt";

        myFile = new File(path); // intitializing new file object

        try {
            if (myFile.exists()== false)
             {
                myFile.createNewFile();  // if file not exist then create one
            }


        }
        catch (Exception e)
        {
            e.printStackTrace();   // printing error in case anything goes wrong
        }
    }


    // public funtion to get the singleton instance and also check for locks for thread safety
    public static FileHandlerSingleton getInstance() {

        if ( File_instance == null)

        {

            synchronized (FileHandlerSingleton.class)    // makin it thread safe

            {
                if ( File_instance == null)
                {
                    File_instance = new FileHandlerSingleton(); // creating new if not exist
                }
            }
        }
        return  File_instance;
    }

    // Method for writing  text in the txt file
    public synchronized void writeToFile(String text)
     {
        FileWriter file_Writer = null;
        BufferedWriter buffer_writer = null;

         PrintWriter writer = null;
        boolean appendMode = true;

        try {

            file_Writer = new FileWriter(myFile, appendMode);
             buffer_writer = new BufferedWriter(file_Writer);

            writer = new PrintWriter(buffer_writer);

            writer.println(text);
        } catch (Exception e)
        {
            e.printStackTrace();

        }
        finally
         {
            try
            {
                if (writer != null)
                {
                    writer.close();
                }
                if (buffer_writer != null)
                {
                    buffer_writer.close();
                }

                if (file_Writer != null)
                {
                    file_Writer.close();
                } // finally closing all the resources preventig resource leaks


            } catch (Exception e)
             {
                e.printStackTrace();
            }
        }
    }

    // Function  for reading  text from the file
    public synchronized String readFromFile()
    {

        StringBuilder content = new StringBuilder();

        FileReader fileReader = null;
        BufferedReader buffer_reader = null;

        try {
            fileReader = new FileReader(myFile);
            buffer_reader = new BufferedReader(fileReader);

            String single_line;

            while ((single_line = buffer_reader.readLine()) != null)
            {
                content.append(single_line).append("\n");
                // append writes at the end of the existing data
            }
        } catch (Exception e)
         {

            e.printStackTrace();


        } finally

        {
            try
            {

                if (buffer_reader !=  null )
                {
                    buffer_reader.close();  // closing the resources
                }

                if ( fileReader!= null  )
                {
                   fileReader.close();
               }



            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return content.toString();  // converting the string builder  to string
    }

    public static void main(String[] args) {


        // Create two instances of the FileHandlerSingleton


        FileHandlerSingleton First_instance = FileHandlerSingleton.getInstance();
        FileHandlerSingleton Second_instance = FileHandlerSingleton.getInstance();

        // Check if they are referring to the same object
        System.out.println("Are instance1 and instance2 referring to the same object: " + (First_instance == Second_instance));

        // Creating  many threads to write to the file at the same time

        Thread writer_Thread1 = new Thread(() -> {
            First_instance.writeToFile("This line was written by Writer Thread1");
        });


        Thread writer_Thread2 = new Thread(() -> {
            First_instance.writeToFile("This line was written by Writer Thread2");
        });  // we wil see that this will not be printed with readerthread
            // as our function is thread safe


        // Create another thread to read from  file
        Thread readerThread = new Thread(() -> {

            String text = Second_instance.readFromFile();

            System.out.println("Data read by reader thread: \n" + text);
        });

        writer_Thread1.start();
        writer_Thread2.start();

        readerThread.start();
        // reader thread will only show data wriiten by one thread only
        // but it will be written after thread 1 is finished


        // Wait for all threads to finish
        try
        {
            writer_Thread1.join();
            writer_Thread2.join();

            readerThread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End of Program");
    }
}
