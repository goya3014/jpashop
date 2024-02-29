package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    @PersistenceContext //spring boot가 entity manager를 주입해줌.
    private EntityManager em;

    //저장
    public Long save(Member member){
        em.persist(member);
        return member.getId();
        //member가 아닌 id를 return하는 이유: command와 query를 분리하기 위해. side effect를 막기위해 보통 return 값을 주지 않지만,
        // id가 있으면 조회가 가능하므로
    }

    //조회
    public Member find(Long id){
        return em.find(Member.class, id);
    }


}
