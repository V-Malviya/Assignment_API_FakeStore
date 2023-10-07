package com.restapi.fakestoreapiproxy;

import com.restapi.fakestoreapiproxy.inheritancePractice.Join_Table.*;
import com.restapi.fakestoreapiproxy.inheritancePractice.Mapped_Table.MSInstructorRepository;
import com.restapi.fakestoreapiproxy.inheritancePractice.Mapped_Table.MSMentorRepository;
import com.restapi.fakestoreapiproxy.inheritancePractice.Mapped_Table.MSTARepository;
import com.restapi.fakestoreapiproxy.inheritancePractice.Single_table.STInstructorRepository;
import com.restapi.fakestoreapiproxy.inheritancePractice.Single_table.STMentorRepository;
import com.restapi.fakestoreapiproxy.inheritancePractice.Single_table.STTARepository;
import com.restapi.fakestoreapiproxy.inheritancePractice.Single_table.STUserRepository;
import com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass.TPCInstructorRepository;
import com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass.TPCMentorRepository;
import com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass.TPCTARepository;
import com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass.TPCUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FakeStoreApiProxyApplicationTests {
    @Test
    void contextLoads() {
    }
    @Autowired
    JTUserRepository jtUserRepository;
    @Autowired
    JTMentorRepository jtMentorRepository;
    @Autowired
    JTInstructorRepository jtInstructorRepository;
    @Autowired
    JTTARepository jttaRepository;
    @Test
    void JoinTableInheritanceCheck()
    {
        User user=new User();
        user.setName("Vaibhav Malviya");
        user.setEmail("xyz@gmail.com");
        User outputUser=jtUserRepository.save(user);
        System.out.println(jtUserRepository.findUserById(outputUser.getId()).toString());

        // lets check for mentor too
        Mentor mentor=new Mentor();
        mentor.setName("Naman Bhalla");
        mentor.setEmail("Naman@Scaler.com");
        mentor.setSessions(99);
        mentor.setMentee(10);
        Mentor outputMentor=jtMentorRepository.save(mentor);
        System.out.println(jtMentorRepository.findMentorById(outputMentor.getId()).toString());

        // for Instructor
        Instructor instructor=new Instructor();
        instructor.setEmail("ins1@gmail.com");
        instructor.setName("ins1");
        instructor.setHandsome(true);
        Instructor outputInstructor=jtInstructorRepository.save(instructor);
        System.out.println(jtInstructorRepository.findInstructorById(outputInstructor.getId()).toString());

        // for TA's
        TA ta=new TA();
        ta.setName("Ta1");
        ta.setEmail("ta1@gmail.com");
        ta.setRating(4.50);
        TA outputTA=jttaRepository.save(ta);
        System.out.println(jttaRepository.findTAById(outputTA.getId()).toString());

    }

    @Autowired
    MSInstructorRepository msInstructorRepository;
    @Autowired
    MSTARepository mstaRepository;
    @Autowired
    MSMentorRepository msMentorRepository;
    @Test
    void mappedTableInheritanceCheck()
    {
        // for mentor
        com.restapi.fakestoreapiproxy.inheritancePractice.Mapped_Table.Mentor mentor
                =new com.restapi.fakestoreapiproxy.inheritancePractice.Mapped_Table.Mentor();
        mentor.setName("Naman Bhalla");
        mentor.setEmail("Naman@Scaler.com");
        mentor.setSessions(99);
        mentor.setMentee(10);
        com.restapi.fakestoreapiproxy.inheritancePractice.Mapped_Table.Mentor outputMentor=
                msMentorRepository.save(mentor);
        System.out.println(msMentorRepository.findMentorById(outputMentor.getId()));

        //for Instuctor
        com.restapi.fakestoreapiproxy.inheritancePractice.Mapped_Table.Instructor instructor=
                new com.restapi.fakestoreapiproxy.inheritancePractice.Mapped_Table.Instructor();
        instructor.setEmail("ins1@gmail.com");
        instructor.setName("ins1");
        instructor.setHandsome(true);
        com.restapi.fakestoreapiproxy.inheritancePractice.Mapped_Table.Instructor outputInstructor=
                msInstructorRepository.save(instructor);
        System.out.println(msInstructorRepository.findInstructorById(outputInstructor.getId()).toString());

        // for TA
        com.restapi.fakestoreapiproxy.inheritancePractice.Mapped_Table.TA ta=
                new com.restapi.fakestoreapiproxy.inheritancePractice.Mapped_Table.TA();
        ta.setName("Ta1");
        ta.setEmail("ta1@gmail.com");
        ta.setRating(4.50);
        com.restapi.fakestoreapiproxy.inheritancePractice.Mapped_Table.TA outputTA=
                mstaRepository.save(ta);
        System.out.println(mstaRepository.findTAById(outputTA.getId()).toString());
    }

    @Autowired
    STUserRepository stUserRepository;
    @Autowired
    STInstructorRepository stInstructorRepository;
    @Autowired
    STTARepository sttaRepository;
    @Autowired
    STMentorRepository stMentorRepository;
    @Test
    void singleTableInheritanceCheck()
    {
        // for User
        com.restapi.fakestoreapiproxy.inheritancePractice.Single_table.User user=
                new com.restapi.fakestoreapiproxy.inheritancePractice.Single_table.User();
        user.setName("Vaibhav Malviya");
        user.setEmail("xyz@gmail.com");
        com.restapi.fakestoreapiproxy.inheritancePractice.Single_table.User outputUser
                = stUserRepository.save(user);
        System.out.println(stUserRepository.findUserById(outputUser.getId()).toString());

        // for Mentor
        com.restapi.fakestoreapiproxy.inheritancePractice.Single_table.Mentor mentor
                = new com.restapi.fakestoreapiproxy.inheritancePractice.Single_table.Mentor();
        mentor.setName("Naman Bhalla");
        mentor.setEmail("Naman@Scaler.com");
        mentor.setSessions(99);
        mentor.setMentee(10);
        com.restapi.fakestoreapiproxy.inheritancePractice.Single_table.Mentor outputMentor
                =stMentorRepository.save(mentor);
        System.out.println(stMentorRepository.findMentorById(outputMentor.getId()).toString());

        // for instructor
        com.restapi.fakestoreapiproxy.inheritancePractice.Single_table.Instructor instructor=
                new com.restapi.fakestoreapiproxy.inheritancePractice.Single_table.Instructor();
        instructor.setEmail("ins1@gmail.com");
        instructor.setName("ins1");
        instructor.setHandsome(true);
        com.restapi.fakestoreapiproxy.inheritancePractice.Single_table.Instructor outputInstructor=
                stInstructorRepository.save(instructor);
        System.out.println(stInstructorRepository.findInstructorById(outputInstructor.getId()).toString());

        // for TA
        com.restapi.fakestoreapiproxy.inheritancePractice.Single_table.TA ta=
                new com.restapi.fakestoreapiproxy.inheritancePractice.Single_table.TA();
        ta.setName("Ta1");
        ta.setEmail("ta1@gmail.com");
        ta.setRating(4.50);
        com.restapi.fakestoreapiproxy.inheritancePractice.Single_table.TA outputTA=sttaRepository.save(ta);
        System.out.println(sttaRepository.findTAById(outputTA.getId()).toString());

    }

    @Autowired
    TPCUserRepository tpcUserRepository;
    @Autowired
    TPCMentorRepository tpcMentorRepository;
    @Autowired
    TPCInstructorRepository tpcInstructorRepository;
    @Autowired
    TPCTARepository tpctaRepository;
    @Test
    void tablePerClassInheritanceCheck()
    {
        // for user
        com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass.User user
                =new com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass.User();
        user.setName("Vaibhav Malviya");
        user.setEmail("xyz@gmail.com");
        com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass.User outputUser=
                tpcUserRepository.save(user);
        System.out.println(tpcUserRepository.findUserById(outputUser.getId()).toString());

        // for Mentor
        com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass.Mentor mentor
                =new com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass.Mentor();
        mentor.setName("Naman Bhalla");
        mentor.setEmail("Naman@Scaler.com");
        mentor.setSessions(99);
        mentor.setMentee(10);
        com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass.Mentor outputMentor
                =tpcMentorRepository.save(mentor);
        System.out.println(tpcMentorRepository.findMentorById(outputMentor.getId()).toString());

        // for Instructor
        com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass.Instructor instructor=
                new com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass.Instructor();
        instructor.setEmail("ins1@gmail.com");
        instructor.setName("ins1");
        instructor.setHandsome(true);
        com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass.Instructor outputInstructor
                =tpcInstructorRepository.save(instructor);
        System.out.println(tpcInstructorRepository.findInstructorById(outputInstructor.getId()).toString());

        // for TA's
        com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass.TA ta=
                new com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass.TA();
        ta.setName("Ta1");
        ta.setEmail("ta1@gmail.com");
        ta.setRating(4.50);
        com.restapi.fakestoreapiproxy.inheritancePractice.TablePerClass.TA outputTA
                =tpctaRepository.save(ta);
        System.out.println(tpctaRepository.findTAById(outputTA.getId()).toString());
    }
}
