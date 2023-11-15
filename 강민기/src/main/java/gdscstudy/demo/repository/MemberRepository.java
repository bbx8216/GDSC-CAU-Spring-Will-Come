package gdscstudy.demo.repository;

import gdscstudy.demo.domain.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {
    Member save(Member member);
    Optional<Member> findById(Long id); // id로 회원 찾기
    Optional<Member> findByName(String name); // 없으면 null이 반환되는데, 그렇게 반환하지 않고 Optional이란것으로 감싸서 반환한다.
    List<Member> findAll(); // 지금까지 저장된 모든 회원 리스트 반환.
}
