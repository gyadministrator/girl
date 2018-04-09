package springboot.girl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author gaoyun
 * 2018/4/9 9:26
 * 描述:
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {
    /**
     * 通过年龄查询女生
     *
     * @param age 年龄
     * @return 女生集合
     * 方法名findByxxx
     */
    List<Girl> findByAge(Integer age);
}
