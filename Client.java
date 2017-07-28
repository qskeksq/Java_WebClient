import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	Socket client;
	
	public Client(){	  
		try {			       //������ �ּ�=ip
			client = new Socket("127.0.0.1" , 8080);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// �����ϴ� ���� ��Ĺ�� Ŭ���̾�Ʈ ������ ����ȴ�.

	public void openConnection(){
		try{
			OutputStream os = client.getOutputStream();
			InputStream is = client.getInputStream();
			
			// 1. �ڿ� ��û
			String uri = "GET /bbb.jsp HTTP/1.1 \r\n";
			uri += "Host: 127.0.0.1:8080 \r\n";
			uri += "Connection: keep-alive \r\n";
			uri += "Accept: */* \r\n";
			
			os.write(uri.getBytes());
			os.flush();
			
			// 2. ���� Ȯ��
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = "";
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
			
			os.close();
			is.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
}
