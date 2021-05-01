import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from 'src/app/customer-service.service';


@Component({
  selector: 'app-all-customers',
  templateUrl: './all-customers.component.html',
  styleUrls: ['./all-customers.component.css']
})
export class AllCustomersComponent implements OnInit {
  cust: any[];
  searchText: any;

  constructor(private cService: CustomerServiceService) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.cService.getAllCustomers().subscribe(data => {
      this.cust = data;
    });

  }

  deleteCustomer(id: number) {
    if(confirm("Are you sure you want to delete?")){
      this.cService.deleteCustomer(id).subscribe(data => {
        this.getAll();
      })
    }
    else{
      this.getAll();
    }
    
  }

}
