package com.bank.web.test;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
import java.io.FileReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class FileTest {
	final public static String FILE_PATH = "C:"+File.separator+
			"Users"+File.separator+"user"+File.separator+
			"eclipse_jee"+File.separator+"jee-bitcamp"+File.separator+
			"WebContent"+File.separator+"resources"+File.separator+"txt"+File.separator;
	public static void main(String[] args) {
		try {
			File file = new File(FILE_PATH + "list.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
			BufferedReader reader = new BufferedReader(new FileReader(file));
			List<String> list = new ArrayList<String>();
			// 모아서 보내기위해 버퍼를 사용 지금코드는 어차피 한번에쳐서 보내기때문에 안써도 문제는 없다.
			String msg ="";
			while (true) {
				switch (JOptionPane.showInputDialog("0.종료\n1.파일저장\n2.파일읽기")) {
				case "0":
					JOptionPane.showMessageDialog(null, "종료");
					return;
				case "1":
					msg = JOptionPane.showInputDialog("메세지를 입력해주세요. 데이터 사이에 ,를 입력");
					writer.write(msg);
					writer.newLine();	//줄바꿈
					writer.flush();		//전송
					break;
				case "2":
					while((msg = reader.readLine()) != null) {
						list.add(msg +"/\n");
					}
					JOptionPane.showMessageDialog(null, list);
					reader.close();
					break;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
