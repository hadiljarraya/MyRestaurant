package myapp_server;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.io.PrintWriter;
import java.io.StringWriter;

import java.net.Socket;
public class server {

	

		public static void main(String[] args) {
			// TODO Auto-generated method 
			try
			{
		ServerSocket socketServeur = new ServerSocket(1234);	
		System.out.println("Serveur en attente");
		while(true) {	
				Socket socket = socketServeur.accept();
				System.out.println("accept");
				InputStream is = socket.getInputStream();
				InputStreamReader isr= new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String[] s= br.readLine().split(" ");

	int result =0;
	switch (s[1]) {
	case "+":{ result=Integer.parseInt(s[0])+Integer.parseInt(s[2]);break;}

	case "*":{ result=Integer.parseInt(s[0])*Integer.parseInt(s[2]);break;}

	case "/":{ result=Integer.parseInt(s[0])/Integer.parseInt(s[2]);break;}
		
	case "-": {result=Integer.parseInt(s[0])-Integer.parseInt(s[2]);break;}

	default :{System.out.println("cest pas unne equoition");}
	}
				



		System.out.println(result);

			OutputStream os=socket.getOutputStream();
		PrintWriter pw=new PrintWriter(os,true);
		pw.println(""+result);
		
		socket.close();

			}}
		catch(Exception ex) {
			System.out.println("eror");
		} 

		}

		private static void clientstring(int result) {
			// TODO Auto-generated method stub
			
		}

	}

