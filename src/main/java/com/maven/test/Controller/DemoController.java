package com.maven.test.Controller;

import com.maven.test.model.ttt;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {

    public static final Logger log = Logger.getLogger(DemoController.class);

    @RequestMapping(value="/user",method= RequestMethod.GET)
    public String dd(){
        return "/api/user";
    }

    @RequestMapping(value="/user/{id}",method=RequestMethod.GET)
    public ResponseEntity<?> getuser(@PathVariable("id") String id,
                                     @RequestParam(value="name",defaultValue = "default_name") String name){

        ttt t = new ttt();
        t.setFirst(name);
        t.setSecond(1);
        return new ResponseEntity<ttt>(t,HttpStatus.OK);
    }

    @RequestMapping(value="/user/{id}",method=RequestMethod.POST)
    public ResponseEntity<?> postuser(@PathVariable("id") String id,
                                     @RequestParam(value="name",defaultValue = "default_name") String name){

        ttt t = new ttt();
        t.setFirst("String");
        t.setSecond(3);
        return new ResponseEntity<ttt>(t,HttpStatus.OK);

    }

    @RequestMapping(value="/user/{id}/d",method=RequestMethod.GET)
    public ResponseEntity<?> getuserd(@PathVariable("id") String id){

        ttt t = new ttt();
        t.setFirst("ddddd");
        t.setSecond(1);
        return new ResponseEntity<ttt>(t,HttpStatus.OK);

    }

    @RequestMapping(value="/command",method = RequestMethod.GET)
    public String pub_commnad() throws IOException {

        Process process = null;
        Runtime runtime = Runtime.getRuntime();
        StringBuffer successOutput = new StringBuffer(); // 성공 스트링 버퍼
        StringBuffer errorOutput = new StringBuffer(); // 오류 스트링 버퍼
        BufferedReader successBufferReader = null; // 성공 버퍼
        BufferedReader errorBufferReader = null; // 오류 버퍼
        String msg = null; // 메시지

        List<String> cmdList = new ArrayList<String>();

        // 운영체제 구분 (window, window 가 아니면 무조건 linux 로 판단)
        if (System.getProperty("os.name").indexOf("Windows") > -1) {
            cmdList.add("cmd");
            cmdList.add("/c");
        } else {
            cmdList.add("/bin/sh");
            cmdList.add("-c");
        }
        // 명령어 셋팅
        cmdList.add("dir");
        String[] array = cmdList.toArray(new String[cmdList.size()]);

        try {

            // 명령어 실행
            process = runtime.exec(array);

            // shell 실행이 정상 동작했을 경우
            successBufferReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "EUC-KR"));

            while ((msg = successBufferReader.readLine()) != null) {
                successOutput.append(msg + System.getProperty("line.separator"));
            }

            // shell 실행시 에러가 발생했을 경우
            errorBufferReader = new BufferedReader(new InputStreamReader(process.getErrorStream(), "EUC-KR"));
            while ((msg = errorBufferReader.readLine()) != null) {
                errorOutput.append(msg + System.getProperty("line.separator"));
            }

            // 프로세스의 수행이 끝날때까지 대기
            process.waitFor();

            // shell 실행이 정상 종료되었을 경우
            if (process.exitValue() == 0) {
                System.out.println("성공");
                System.out.println(successOutput.toString());
            } else {
                // shell 실행이 비정상 종료되었을 경우
                System.out.println("비정상 종료");
                System.out.println(successOutput.toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                process.destroy();
                if (successBufferReader != null) successBufferReader.close();
                if (errorBufferReader != null) errorBufferReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }


    return "dd";


    }

}
