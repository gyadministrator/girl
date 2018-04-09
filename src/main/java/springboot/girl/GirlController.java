package springboot.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author gaoyun
 * 2018/4/9 9:23
 * 描述:
 */
@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;

    /**
     * 查询女生列表
     *
     * @return 女生集合
     */
    @GetMapping("/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     *
     * @param cupSize 大小
     * @param age     年龄
     * @return 该女生
     */
    @PostMapping("/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 查询一个女生
     *
     * @param id 主键
     * @return 该女生
     */
    @GetMapping("/girls/{id}")
    public Optional<Girl> girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findById(id);
    }

    /**
     * 更新一个女生
     *
     * @param id      主键
     * @param cupSize 大小
     * @param age     年龄
     * @return 该女生
     */
    @PutMapping("/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id, @RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 删除一个女生
     *
     * @param id 主键
     * @return 提示消息
     */
    @DeleteMapping("/girls/{id}")
    public String girlDelete(@PathVariable("id") Integer id) {
        try {
            girlRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        } finally {
            return "删除成功";
        }
    }

    /**
     * 通过年龄查询女生
     *
     * @param age 年龄
     * @return 女生列表
     */
    @GetMapping("/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }
}
