import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  constructor(private http:HttpClient) { }
  url='http://localhost:8080/dashboard';

  listUtilisateur(){
    return this.http.get(this.url+"/getAllUtilisateur");
  }
  ajouterApprenant(data: any){
    console.log(data);
    return this.http.post("http://localhost:8080/ajoutUtilisateur", data);
}

listUser(){
  return this.http.get(this.url+"/getUtilisateurById/{id}");
}
suprime(id:any){
  return this.http.delete(this.url+"/deleteUtilisateur/"+id, {responseType: 'text'})
}
listapprenant(){
  return this.http.get(this.url+"/profile=apprenant");
}
listformateur(){
  return this.http.get(this.url+"/profile=formateur")
}
modifierUser(id:any){
  return this.http.put(this.url+"/modifyUtilisateur/"+id, id)
}
User(id:any){
  return this.http.get(this.url+"getUtilisateurById/"+id,{responseType:'text'} )
}
}
