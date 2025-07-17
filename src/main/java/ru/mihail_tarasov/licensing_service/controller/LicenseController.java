package ru.mihail_tarasov.licensing_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mihail_tarasov.licensing_service.model.License;
import ru.mihail_tarasov.licensing_service.service.LicenseService;

@RestController
@RequestMapping(value="v1/organization/{organizationId}/license")
        public class LicenseController {
        @Autowired
        private LicenseService licenseService;

        @GetMapping(value = "/{licenseId")
        public ResponseEntity<License>getLicense(
                @PathVariable("organizationId") String organizationId,
                @PathVariable("licenseId") String licenseId){

                License license= licenseService.getLicense(licenseId,organizationId);
                return ResponseEntity.ok(license);
        }

        @PutMapping
        public ResponseEntity<String>updateLicense(
                @PathVariable("organizationId") String organizationId,@RequestBody License request){
                return ResponseEntity.ok(licenseService.createlicense(request,organizationId));
        }

        @DeleteMapping(value = "/{licenseId")
        public ResponseEntity<String> deleteLicense(
                @PathVariable("organizationId") String organizationId,@PathVariable("licenseId") String licenseId) {
                return ResponseEntity.ok(licenseService.deleteLicense(licenseId, organizationId));
        }
}
