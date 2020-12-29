package grocery.gohool.loginnregister;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    //서버 URL설정 / 고정값 / 심어논 php파일과 연결하는 과정
    final static private String URL = "http://skatpgnsx.dothome.co.kr/Login.php";
    private Map<String, String> map;


    //회원가입 요청을위해 생성자 만들어줌
    public LoginRequest(String userID, String userPassword, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);


        map = new HashMap<>();
        map.put("userID", userID);
        map.put("userPassword", userPassword);

    }


    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
