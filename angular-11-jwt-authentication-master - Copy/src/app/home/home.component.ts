import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { Donor } from '../common/donor';
import { UserService } from '../_services/user.service';
import { ShareService } from '../_services/share-service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';
import { User } from '../common/user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  NgForm=NgForm;
  
   

  form2: any = {
    pid:"",
    prescription : ""
  };


  form: any = {
    pid:"",
    prescription : ""
  };

  donors:User[] | undefined;

  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  did:any;

  constructor(private s : ShareService,private authService: AuthService, private userService: UserService,private router: Router
    ) { }

  ngOnInit(): void {


    
    this.userService.getPublicContent2(this.did).subscribe(
      data => {
        this.donors = data;
      }
    );
    


  }

  edit(donor: any){
    this.form=donor;
  }
 

  clear(){
    this.form=this.form2;
  }


  onDelete(id:number | undefined): void {
    this.userService.delete(id);
    console.log("Hello");
  }


  onSubmit(): void {
    const {pid,prescription} = this.form;

    this.authService.store2(pid,prescription).subscribe(
      data => {
        console.log(data);
        this.userService.getPublicContent2(this.did).subscribe(
          data => {
            this.donors = data;
          }
        );
      },
      err => {
        console.log(err);
      }
    );
  }

  logout():void{
    console.log("Hello")
   this.s.set2(true);
   this.router.navigate(['/doclogin']);
  }



   navigate():void{
     console.log("Hello")
    this.s.set2(true);
    this.router.navigate(['/admin/usermg']);
   }
  

  

}
