import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Member } from 'src/models/member';

@Injectable({
  providedIn: 'root'
})
export class MemberService {
  constructor(private http:HttpClient){}
  // fonctions qui representent des CRUD sur Member
  getAllMembers():Observable<Member[]>
  {
  // envoyer une requete http en mode GET
  return this.http.get<Member[]>('http://localhost:3000/members');
  }
  save (member:any): Observable<void>
{
// envoyer une requete en mode POST vers le back end
return this.http.post<void>('http://localhost:3000/members',member)
}
getMemberById(id: string): Observable<Member> {
  return this.http.get<Member>(`http://localhost:3000/members/${id}`);
}
updateMember(id: string, member: Member): Observable<Member> {
  return this.http.put<Member>(`http://localhost:3000/members/${id}`, member);
}
deleteMember(id:string){
  return this.http.delete<void>(`http://localhost:3000/members/${id}`)
}
}