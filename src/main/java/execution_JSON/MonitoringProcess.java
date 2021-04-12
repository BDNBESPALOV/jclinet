package execution_JSON;

import org.slf4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MonitoringProcess implements Exec{
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(MonitoringProcess.class);



    @Override
    public void doProcess(int pid,String str,PrintWriter out) {
            log.info("exec MonitoringProcess ...");
        try {

            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("bash", "-c", "ps -e --format='pid cmd'|grep java");

            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            int index = 0;
            String line;
            while ((line = reader.readLine()) != null) {

                if (line.charAt(0) == ' '){
                    line = line.substring(1);
                }

                index = line.indexOf(" ");
                if (index>0){
                    if (line.contains(" grep java")){
                        continue;
                    }
                    out.println("Key:" + line.substring(0,index) + "Value:" + line.substring(index));

                }

            }

            process.waitFor();


        } catch (IOException | InterruptedException e) {
            log.info("ERROR: "+e);
        }

    }


}
