import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../_services/token-storage.service';
import { AuthService } from '../_services/auth.service';
import { ShareService } from '../_services/share-service';
import { Router, ActivatedRoute } from '@angular/router';
import { Donor } from '../common/donor';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  currentUser: any;
  pname : any;
  pemail : any;
  phone : any;
  doctors:Donor[] | undefined;
  count:number=0;
  constructor(private authService: AuthService,private userService: UserService, private s : ShareService,private router: Router) { }

  ngOnInit(): void {
   
    this.userService.getPublicContent().subscribe(
      data => {
        this.doctors = data;
      }
    );
  }

   navigate():void{
   
    this.s.set2(true);
    this.router.navigate(['/home']);
   }

   fetchAll(doctor: { did: number | undefined; }){
    this.count++;
    
    
    //this.s.alldetails=doctor;
    //this.s.alldetails+=this.patientService.patientDetails;
    //console.log(this.s.alldetails)
  }

  




  submit(doctor: { did: number | undefined;slot:string|undefined }){

    if(doctor.slot == 'A1'){
   
 
    this.authService.setavail(doctor.did).subscribe();




    this.authService.setDoctors(doctor.did,this.authService.pid).subscribe(
      (resp)=>{
        console.log(resp);
      },
      (err)=>{
        console.log(err);
      }
    );
  
    this.userService.getPublicContent().subscribe(
      data => {
        this.doctors = data;
      }
    );
  
  }

    else if(doctor.slot == 'A2'){
      console.log(this.authService.pid);

      this.authService.setavail(doctor.did).subscribe();


      this.authService.setDoctors2(doctor.did,this.authService.pid).subscribe(
        (resp)=>{
          console.log(resp);
        },
        (err)=>{
          console.log(err);
        }
      );
     
      this.userService.getPublicContent().subscribe(
        data => {
          this.doctors = data;
        }
      );

    }

    }
    
    logout():void{
      console.log("Hello")
     this.s.set2(true);
     this.router.navigate(['/user/login']);
    }
  


}
