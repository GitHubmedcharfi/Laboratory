import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MemberComponent } from './member/member.component';
import { MemberFormComponent } from './member-form/member-form.component';

const routes: Routes = [
  {path : 'create',
    pathMatch:'full',
    component:MemberFormComponent
    },
    {
    path : '',
    pathMatch:'full',
    component: MemberComponent
    },
    {path:':id/edit',
      pathMatch:'full',
      component:MemberFormComponent
      },
    {
    path :'member',
    component: MemberComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
 }
