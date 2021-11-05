import { Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { FormControl, FormGroup } from '@angular/forms';
import { ServiceService } from '../Service/service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-ajouter',
  templateUrl: './ajouter.component.html',
  styleUrls: ['./ajouter.component.scss']
})
export class AjouterComponent implements OnInit {
  [x: string]: any;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(
    private breakpointObserver: BreakpointObserver,
    private form: FormGroup,
    private serv:ServiceService,
    private route : ActivatedRoute)
    {}
    UpdateUtilisateur = new FormGroup({
      nom:new FormControl(''),
      prenom:new FormControl(''),
      age:new FormControl(''),
      telephone:new FormControl(''),
      email:new FormControl(''),
      login:new FormControl(''),
      password:new FormControl(''),
      genre:new FormControl(''),
      status:new FormControl(''),
      profile:new FormControl(''),
      dateCretion:new FormControl(''),
      dateModification:new FormControl(''),
    }
    );
    message:boolean=false;
  ngOnInit():void {

  }
  SaveData(){
    // console.log(this.addStudent.value);
    this.student.saveStudentData(this.UpdateUtilisateur.value).subscribe((result: any)=>{
      this.message=true;
    })

  }
  removeMessage(){
    this.message=false;
  }


}
