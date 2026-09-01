package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Brad42 {

	public static void main(String[] args) {
		try (FileInputStream fin = new FileInputStream("dir1/ns1hosp.csv");
				InputStreamReader ir = new InputStreamReader(fin);
				BufferedReader reader = new BufferedReader(ir);
				){
			String line = reader.readLine();
			//System.out.println(line);
			
			while ( (line = reader.readLine()) != null) {
				try {
					String[] data = line.split(",");
					System.out.println(data[2] + ":" + data[7]);
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
