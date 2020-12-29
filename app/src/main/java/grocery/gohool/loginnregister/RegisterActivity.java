package grocery.gohool.loginnregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

//회원가입
public class RegisterActivity extends AppCompatActivity {

    private EditText register_id,register_password,register_age,register_name;
    private Button register_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_id = (EditText) findViewById(R.id.register_id);
        register_password = (EditText) findViewById(R.id.register_password);
        register_age = (EditText) findViewById(R.id.register_age);
        register_name = (EditText) findViewById(R.id.register_name);

        register_btn = (Button) findViewById(R.id.register_btn);
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //값을 받아옴
                String userID = register_id.getText().toString();
                String userPassword = register_id.getText().toString();
                String username = register_id.getText().toString();
                int userAge = Integer.parseInt(register_age.getText().toString());

                //요청에 대한 응답
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                      //JSON : 운반할때 포장하고, 완료되면 풀어주는 / 회원가입 요청 후 결과값을 JSON 오브젝으토 받음(성공여부)
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){
                                Toast.makeText(getApplicationContext(), "회원가입 성공!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(getApplicationContext(), "회원가입 실패ㅠ", Toast.LENGTH_SHORT).show();
                                return; //도돌이표
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                // 다 만들었으면 만든거 담아줌 / 서버로 volley를 이용해서 요청을 함
                RegisterRequest registerRequest = new RegisterRequest(userID,userPassword,username,userAge,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);

            }
        });

    }
}