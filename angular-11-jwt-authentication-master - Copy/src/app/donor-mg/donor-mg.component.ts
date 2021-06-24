import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { Donor } from '../common/donor';
import { UserService } from '../_services/user.service';
import { ShareService } from '../_services/share-service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-donor-mg',
  templateUrl: './donor-mg.component.html',
  styleUrls: ['./donor-mg.component.css']
})



export class DonorMgComponent implements OnInit {
  NgForm=NgForm;
  
  donorToUpdate={
    did: "",
    availability: "",
    dname: "",
    emailid: "",
    password: "",
    specialization: "",
    slot: ""
  };

   

  form2: any = {
    did: "",
    availability: "",
    dname: "",
    emailid: "",
    password: "",
    specialization: "",
    slot: ""
  };


  form: any = {
    did: "",
    availability: "",
    dname: "",
    emailid: "",
    password: "",
    specialization: "",
    slot: ""
  };

  donors:Donor[] | undefined;

  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private s : ShareService,private authService: AuthService, private userService: UserService,private router: Router
    ) { }

  ngOnInit(): void {

    this.userService.getPublicContent().subscribe(
      data => {
        this.donors = data;
      }
    );
    


  }

  edit(donor: { did: number |undefined  ; availability: number | undefined,
  dname:string|undefined,
  emailid: string|undefined,
  password: string|undefined,
  specialization: string|undefined,
  slot: string|undefined}){
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
    const {  did,
    availability,
    dname,
    emailid,
    password,
    specialization,
    slot} = this.form;

    this.authService.store(did,
      availability,
      dname,
      emailid,
      password,
      specialization,slot).subscribe(
      data => {
        console.log(data);
        // this.isSuccessful = true;
        // this.isSignUpFailed = false;
      },
      err => {
        // this.errorMessage = err.error.message;
        // this.isSignUpFailed = true;
      }
    );

    this.userService.getPublicContent().subscribe(
      data => {
        this.donors = data;
      }
    );
  }

  



   navigate():void{
     console.log("Hello")
    this.s.set2(true);
    this.router.navigate(['/admin/usermg']);
   }

   logout():void{
    console.log("Hello")
   this.s.set2(true);
   this.router.navigate(['/admin']);
  }

}
