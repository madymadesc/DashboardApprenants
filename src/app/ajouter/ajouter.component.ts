import { Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { ServiceService } from '../Service/service.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-ajouter',
  templateUrl: './ajouter.component.html',
  styleUrls: ['./ajouter.component.scss']
})
export class AjouterComponent implements OnInit {
  options!: FormGroup;
  ajoutform: any;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(
    private breakpointObserver: BreakpointObserver,
    private serv:ServiceService,
    private route : ActivatedRoute,
    private formb: FormBuilder,
    private http: HttpClient
    )
    {
      this.options=this.formb.group({

      })
    }
    // ajouterUtilisateur = new FormGroup({
    //   nom:new FormControl(''),
    //   prenom:new FormControl(''),
    //   age:new FormControl(''),
    //   telephone:new FormControl(''),
    //   email:new FormControl(''),
    //   login:new FormControl(''),
    //   password:new FormControl(''),
    //   genre:new FormControl(''),
    //   status:new FormControl(''),
    //   profile:new FormControl(''),
    //   dateCreation:new FormControl(''),
    //   dateModification:new FormControl(''),
    // }
    // );
  ngOnInit():void {

  }
  // SaveData(form: NgForm){
  //   this.serv.ajouterApprenant(form.value);

  //   console.log(this.form.value);

  // }
ajout(form: NgForm){
  // this.ajoutform={
  //   "nom":""+this.options.value.nom,
  //   "prenom":""+this.options.value.prenom,
  //   "age":""+this.options.value.age,
  //   "telephone":""+this.options.value.telephone,
  //   "email":""+this.options.value.email,
  //   "login":""+this.options.value.login,
  //   "password":""+this.options.value.password,
  //   "genre":""+this.options.value.genre,
  //   "status":""+this.options.value.status,
  //   "profile":""+this.options.value.profile,
  // }
  // console.log(form.value)
  this.http.post("http://localhost:8080/dashboard/ajoutUtilisateur", form).subscribe()
  this.options.reset()
}
}
