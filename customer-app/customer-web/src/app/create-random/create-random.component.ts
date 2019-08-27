import { EmployeeService } from '../employee.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-random',
  templateUrl: './create-random.component.html',
  styleUrls: ['./create-random.component.css']
})
export class CreateRandomComponent implements OnInit {

  submitted = false;

  constructor(private employeeService: EmployeeService,
    private router: Router) { }

  ngOnInit() {
    console.log('create-random - ngOnInit()');
    this.employeeService.createRandomEmployee()
    .subscribe(data => {
      console.log(data);
      this.router.navigate(['/employees']);
    }, error => console.log(error));
    
  }

  
  onSubmit() {
    this.submitted = true;
    console.log('create-random - onSubmit()');
  }

  gotoList() {
    console.log('create-random - gotoList()');
    this.router.navigate(['/employees']);
  }
}