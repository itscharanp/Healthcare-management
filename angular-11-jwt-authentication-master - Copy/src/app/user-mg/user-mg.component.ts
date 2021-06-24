import { Component, OnInit } from '@angular/core';
import { User } from '../common/user';
import { UserService } from '../_services/user.service';
import { ShareService } from '../_services/share-service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-mg',
  templateUrl: './user-mg.component.html',
  styleUrls: ['./user-mg.component.css']
})
export class UserMgComponent implements OnInit {

  form: any = {
    name: null,
    email: null,
    phonenumber:null,
  };

  users:User[] | undefined;


  constructor(private s : ShareService,private userService: UserService,private router: Router) { }

  ngOnInit(): void {
    this.userService.getUserBoard().subscribe(
      data => {
        this.users = data;
      }
    );
    
  }

  onSubmit(id:number | undefined): void {
    this.userService.getAdminBoard(id);
    console.log("Hello");
  }

  navigate():void{
    console.log("Hello")
   this.s.set2(true);
   this.router.navigate(['/admin/donormg']);
  }

}
