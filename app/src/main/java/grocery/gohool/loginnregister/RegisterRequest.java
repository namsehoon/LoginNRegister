package grocery.gohool.loginnregister;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    //서버 URL설정 / 고정값 / 심어논 php파일과 연결하는 과정
    final static private String URL = "http://skatpgnsx.dothome.co.kr/Register.php";
    private Map<String, String> map;


    //회원가입 요청을위해 생성자 만들어줌
    public RegisterRequest(String userID, String userPassword, String userName, int userAge, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);


        map = new HashMap<>();
        map.put("userID", userID);
        map.put("userPassword", userPassword);
        map.put("userName", userName);
        //가라 스트링
        map.put("userAge", userAge + "");
    }


    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
