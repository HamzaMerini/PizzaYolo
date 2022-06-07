import {
  AbstractControl,
  FormGroup,
  ValidationErrors,
  ValidatorFn,
} from '@angular/forms';

export class CustomValidator {
  public static equals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    let password = group.controls['password'];
    let confirmPassword = group.controls['confirmPassword'];
    return password.dirty && password.value != confirmPassword.value
      ? { equals: true }
      : null;
  }
}
