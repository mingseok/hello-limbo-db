package hello.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MemberExportService {

    public void exportMembersToJson(List<Member> members, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filePath), members);
            System.out.println("회원 데이터를 JSON 파일로 저장: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
