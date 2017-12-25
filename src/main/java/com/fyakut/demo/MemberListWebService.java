package com.fyakut.demo;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class MemberListWebService {

 /**   http://localhost:8080/memberList ile get metod sonucuna ulaşır.
    username="adminUser"
    password="adminUserPassword"  değerleri girilmeli
  sonuc:

  [{"name":"ufy","surname":"yakut","city":"amed","company":"saha","address":{"neighborhood":"kayapınar","borough":"Amed","country":"turkiye"}},
  {"name":"Serkan","surname":"Akbaba","city":"İstanbul","company":"Saha","address":{"neighborhood":"Cennet Mahallesi","borough":"K.Çekmece","country":"TÜRKİYE"}},
  {"name":"Ertan","surname":"Şahin","city":"İstanbul","company":"Saha","address":{"neighborhood":"Maslak","borough":"Sarıyer","country":"TÜRKİYE"}}]

  */
@RequestMapping(value = "/memberList",method = GET)
public List<Member> getExample(@RequestParam(value = "MemberId", defaultValue = "0") String id) {
    List<Member> memberList = new ArrayList<>();

    Member member1=new Member("ufy","yakut","amed","saha",
            new Address("kayapınar","Amed","turkiye"));
memberList.add(member1);


    Member member2 = new Member("Serkan", "Akbaba", "İstanbul", "Saha",
            new Address("Cennet Mahallesi", "K.Çekmece", "TÜRKİYE"));
    memberList.add(member2);

    Member member3 = new Member("Ertan", "Şahin", "İstanbul", "Saha",
            new Address("Maslak", "Sarıyer", "TÜRKİYE"));
    memberList.add(member3);

    if (id.equals("0")) {
        return memberList;
    } else {
        return memberList.subList(Integer.parseInt(id) - 1, Integer.parseInt(id));
    }
}

}
