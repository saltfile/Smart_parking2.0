package com.example.provider.entiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                   //生成get set equals toString等方法
@AllArgsConstructor     //生成一个全属性构造方法
@NoArgsConstructor      //生成无参构造方法
public class Controller {

    private String ctr_id;             //管理员账号
    private String ctr_password;       //管理员密码

}
