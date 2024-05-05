package projectmicroservice.projectcrawl;

import reactor.core.publisher.Flux;

public interface EmployeeService {
    Flux<Employee> findAll();
}
