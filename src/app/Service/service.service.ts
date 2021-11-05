import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Utilisateur } from '../module/utilisateur';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  constructor(private http:HttpClient) { }

   //   this.http.get('http://localhost:8080/apprenantOdk/apprenant')
  //   .subscribe(data => {
  //     this.list.push(data);
  //     }
  //   );
  // }
  url='http://localhost:8080/dashboard';

  // getList(){
  //     return this.list;
  // listApprenant(){
  //   return this.http.get('http://localhost:8080/dashboard/getAllUtilisateur');
  // }
  listApprenant(){
    return this.http.get(this.url+"/getAllUtilisateur");
  }
  ajouterApprenant(data: any){
    console.log(data);
    return this.http.post("http://localhost:8080/ajoutUtilisateur", data);

  // Url= 'http://localhost:8080/dash_db/utilisateur';
  // getUsers(){
  //   return this.http.get<Utilisateur[]>(this.Url)
  // }

}
}
